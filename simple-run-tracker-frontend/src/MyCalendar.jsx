import { Calendar, momentLocalizer } from "react-big-calendar";
import moment from "moment";
import "react-big-calendar/lib/css/react-big-calendar.css";
import ApiService from "./services/apiService.ts";
import {useEffect, useState} from "react";
import TrainingService from "./services/trainingService.ts";

const localizer = momentLocalizer(moment);

const apiService = new ApiService("http://localhost:8080");
const trainingService = new TrainingService()

const MyCalendar = () => {
    const [events, setEvents] = useState([]);

    useEffect(() => {
        apiService.getTrainings().then(response => {
            console.log(response.data);
            const tmp = trainingService.mapToCalendarEvents(response.data)
            console.log(tmp)
            setEvents(tmp);
        });
    }, []);

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
            />
        </div>
    );
};

export default MyCalendar;
