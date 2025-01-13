// Importy wymagane do działania aplikacji
import { Calendar, momentLocalizer } from "react-big-calendar";
import moment from "moment";
import "react-big-calendar/lib/css/react-big-calendar.css";

// Lokalizacja za pomocą biblioteki moment
const localizer = momentLocalizer(moment);

// Przykładowe wydarzenia
const events = [
    {
        title: "Spotkanie zespołu",
        start: new Date(2025, 0, 15, 10, 0), // 15 stycznia 2025, 10:00
        end: new Date(2025, 0, 15, 11, 0), // 15 stycznia 2025, 11:00
    },
    {
        title: "Prezentacja projektu",
        start: new Date(2025, 0, 16, 14, 0), // 16 stycznia 2025, 14:00
        end: new Date(2025, 0, 16, 15, 30), // 16 stycznia 2025, 15:30
    },
];

// Główna aplikacja
const MyCalendar = () => {
    return (
        <div style={{ height: "100vh", width: "90vw", padding: "20px" }}>
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
