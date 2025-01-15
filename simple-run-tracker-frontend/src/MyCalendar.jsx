import { Calendar, momentLocalizer } from "react-big-calendar";
import moment from "moment";
import "react-big-calendar/lib/css/react-big-calendar.css";
import ApiService from "./services/apiService.ts";
import { useEffect, useState, useRef } from "react";
import TrainingService from "./services/trainingService.ts";
import PlannedTrainingService from "./services/plannedTrainingService.ts";
import TrainingModal from "./TrainingModal.jsx";
import PlannedTrainingModal from "./PlannedTrainingModal.jsx";
import AddTrainingModal from "./AddTrainingModal.jsx";
import AddPlannedTrainingModal from "./AddPlannedTrainingModal.jsx";
import CustomToolbar from "./CustomToolbar.jsx";
import TrainingList from "./TrainingList.jsx";

const localizer = momentLocalizer(moment);

const apiService = new ApiService("http://localhost:8080");
const trainingService = new TrainingService();
const plannedTrainingService = new PlannedTrainingService();

const MyCalendar = () => {
    const [events, setEvents] = useState([]);
    const [trainings, setTrainings] = useState([]);
    const [plannedTrainings, setPlannedTrainings] = useState([]);
    const [showModal, setShowModal] = useState(false);
    const [showPlannedModal, setShowPlannedModal] = useState(false);
    const [selectedTraining, setSelectedTraining] = useState(null);
    const [showAddModal, setShowAddModal] = useState(false);
    const [showAddPlannedModal, setShowAddPlannedModal] = useState(false);
    const trainingListRef = useRef(null);

    useEffect(() => {
        Promise.all([apiService.getTrainings(), apiService.getPlannedTrainings()])
            .then(([trainingsResponse, plannedTrainingsResponse]) => {
                const trainingEvents = trainingService.mapToCalendarEvents(trainingsResponse.data);
                const plannedTrainingEvents = plannedTrainingService.mapToCalendarEvents(plannedTrainingsResponse.data);
                setEvents([...trainingEvents, ...plannedTrainingEvents]);
                setTrainings(trainingsResponse.data);
                setPlannedTrainings(plannedTrainingsResponse.data);
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

    const handleDetailsClick = (training) => {
        setSelectedTraining(training);
        if (training.isPlanned) {
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
            setTrainings([...trainings, response.data]);
        });
    };

    const handleSavePlannedTraining = (newPlannedTraining) => {
        apiService.addPlannedTraining(newPlannedTraining).then(response => {
            const newEvent = plannedTrainingService.mapToCalendarEvent(response.data);
            setEvents([...events, newEvent]);
            setPlannedTrainings([...plannedTrainings, response.data]);
        });
    };

    const handleDeleteTraining = (trainingId) => {
        apiService.deleteTraining(trainingId).then(() => {
            setEvents(events.filter(event => event.training.id !== trainingId));
            setTrainings(trainings.filter(training => training.id !== trainingId));
        });
    };

    const handleDeletePlannedTraining = (plannedTrainingId) => {
        apiService.deletePlannedTraining(plannedTrainingId).then(() => {
            setEvents(events.filter(event => event.training.id !== plannedTrainingId));
            setPlannedTrainings(plannedTrainings.filter(plannedTraining => plannedTraining.id !== plannedTrainingId));
        });
    };

    const eventPropGetter = (event) => {
        const backgroundColor = event.color || 'blue'; // Default color if no color is specified
        return { style: { backgroundColor } };
    };

    const handleShowMore = (events, date) => {
        if (trainingListRef.current) {
            trainingListRef.current.scrollToDate(moment(date).format('YYYY-MM-DD'));
        }
    };

    return (
        <div>
            <Calendar
                localizer={localizer}
                events={events}
                startAccessor="start"
                endAccessor="end"
                style={{ height: "80vh" }}
                onSelectEvent={handleEventClick}
                eventPropGetter={eventPropGetter}
                components={{
                    toolbar: (props) => (
                        <CustomToolbar
                            {...props}
                            onAddTraining={handleAddOpen}
                            onAddPlannedTraining={handleAddPlannedOpen}
                        />
                    )
                }}
                onShowMore={handleShowMore}
                views={["month"]}
            />
            {selectedTraining && (
                <>
                    <TrainingModal
                        show={showModal}
                        handleClose={handleClose}
                        training={selectedTraining}
                        onDelete={handleDeleteTraining}
                    />
                    <PlannedTrainingModal
                        show={showPlannedModal}
                        handleClose={handleClose}
                        training={selectedTraining}
                        onDelete={handleDeletePlannedTraining}
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
            <TrainingList
                ref={trainingListRef}
                trainings={trainings}
                plannedTrainings={plannedTrainings}
                onDetailsClick={handleDetailsClick}
            />
        </div>
    );
};

export default MyCalendar;