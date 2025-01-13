import { Calendar, momentLocalizer } from "react-big-calendar";
import moment from "moment";
import "react-big-calendar/lib/css/react-big-calendar.css";
import ApiService from "./services/apiService.ts";
import {useEffect, useState} from "react";
import TrainingService from "./services/trainingService.ts";
import TrainingModal from "./TrainingModal.jsx";
import {Button} from "react-bootstrap";

const localizer = momentLocalizer(moment);

const apiService = new ApiService("http://localhost:8080");
const trainingService = new TrainingService()

const MyCalendar = () => {
    const [events, setEvents] = useState([]);
    const [showModal, setShowModal] = useState(false);
    const [selectedTraining, setSelectedTraining] = useState(null);

    useEffect(() => {
        apiService.getTrainings().then(response => {
            console.log(response.data);
            const tmp = trainingService.mapToCalendarEvents(response.data)
            console.log(tmp)
            setEvents(tmp);
        });
    }, []);

    const handleEventClick = (event) => {
        setSelectedTraining(event.training);
        setShowModal(true);
    };

    const handleClose = () => setShowModal(false);

    return (
        // <div style={{ height: "100vh", width: "90vw", padding: "20px" }}>
        <div>
            <h1>Mój Kalendarz</h1>
            <Calendar
                localizer={localizer}
                events={events}
                startAccessor="start"
                endAccessor="end"
                style={{ height: "80vh" }}
                onSelectEvent={handleEventClick}
            />
            {selectedTraining && (
            <TrainingModal
                show={showModal}
                handleClose={handleClose}
                training={selectedTraining}
            />)}
        </div>
    );
};

export default MyCalendar;
