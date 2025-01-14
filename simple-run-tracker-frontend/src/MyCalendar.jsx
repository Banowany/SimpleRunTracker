// src/MyCalendar.jsx
import { Calendar, momentLocalizer } from "react-big-calendar";
import moment from "moment";
import "react-big-calendar/lib/css/react-big-calendar.css";
import ApiService from "./services/apiService.ts";
import { useEffect, useState } from "react";
import TrainingService from "./services/trainingService.ts";
import PlannedTrainingService from "./services/plannedTrainingService.ts";
import TrainingModal from "./TrainingModal.jsx";
import PlannedTrainingModal from "./PlannedTrainingModal.jsx";
import { Button } from "react-bootstrap";
import AddTrainingModal from "./AddTrainingModal.jsx";
import AddPlannedTrainingModal from "./AddPlannedTrainingModal.jsx";

const localizer = momentLocalizer(moment);

const apiService = new ApiService("http://localhost:8080");
const trainingService = new TrainingService();
const plannedTrainingService = new PlannedTrainingService();

const MyCalendar = () => {
    const [events, setEvents] = useState([]);
    const [showModal, setShowModal] = useState(false);
    const [showPlannedModal, setShowPlannedModal] = useState(false);
    const [selectedTraining, setSelectedTraining] = useState(null);
    const [showAddModal, setShowAddModal] = useState(false);
    const [showAddPlannedModal, setShowAddPlannedModal] = useState(false);

    useEffect(() => {
        Promise.all([apiService.getTrainings(), apiService.getPlannedTrainings()])
            .then(([trainingsResponse, plannedTrainingsResponse]) => {
                const trainingEvents = trainingService.mapToCalendarEvents(trainingsResponse.data);
                const plannedTrainingEvents = plannedTrainingService.mapToCalendarEvents(plannedTrainingsResponse.data);
                setEvents([...trainingEvents, ...plannedTrainingEvents]);
            })
            .catch(error => {
                console.error("Error fetching data:", error);
            });
    }, []);

    const handleEventClick = (event) => {
        setSelectedTraining(event.training);
        if (event.isPlanned) {
            setShowPlannedModal(true);
        } else {
            setShowModal(true);
        }
    };

    const handleClose = () => {
        setShowModal(false);
        setShowPlannedModal(false);
    };

    const handleAddClose = () => setShowAddModal(false);
    const handleAddOpen = () => setShowAddModal(true);

    const handleAddPlannedClose = () => setShowAddPlannedModal(false);
    const handleAddPlannedOpen = () => setShowAddPlannedModal(true);

    const handleSaveTraining = (newTraining) => {
        apiService.addTraining(newTraining).then(response => {
            const newEvent = trainingService.mapToCalendarEvent(response.data);
            setEvents([...events, newEvent]);
        });
    };

    const handleSavePlannedTraining = (newPlannedTraining) => {
        apiService.addPlannedTraining(newPlannedTraining).then(response => {
            const newEvent = plannedTrainingService.mapToCalendarEvent(response.data);
            setEvents([...events, newEvent]);
        });
    };

    const eventPropGetter = (event) => {
        const backgroundColor = event.color || 'blue'; // Default color if no color is specified
        return { style: { backgroundColor } };
    };

    return (
        <div>
            <h1>Mój Kalendarz</h1>
            <Button onClick={handleAddOpen}>Add Training</Button>
            <Button onClick={handleAddPlannedOpen}>Add Planned Training</Button>
            <Calendar
                localizer={localizer}
                events={events}
                startAccessor="start"
                endAccessor="end"
                style={{ height: "80vh" }}
                onSelectEvent={handleEventClick}
                eventPropGetter={eventPropGetter}
            />
            {selectedTraining && (
                <>
                    <TrainingModal
                        show={showModal}
                        handleClose={handleClose}
                        training={selectedTraining}
                    />
                    <PlannedTrainingModal
                        show={showPlannedModal}
                        handleClose={handleClose}
                        training={selectedTraining}
                    />
                </>
            )}
            <AddTrainingModal
                show={showAddModal}
                handleClose={handleAddClose}
                handleSave={handleSaveTraining}
            />
            <AddPlannedTrainingModal
                show={showAddPlannedModal}
                handleClose={handleAddPlannedClose}
                handleSave={handleSavePlannedTraining}
            />
        </div>
    );
};

export default MyCalendar;