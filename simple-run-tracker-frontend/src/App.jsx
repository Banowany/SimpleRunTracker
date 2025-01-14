import React from 'react';
import MyCalendar from './MyCalendar';
import TrainingSummaryPage from './TrainingSummaryPage';
import AppNavbar from './AppNavbar.jsx';
import {BrowserRouter, Navigate, Route, Routes} from "react-router-dom";

const App = () => {
    return (
        <BrowserRouter>
            <AppNavbar />
            <Routes>
                <Route path="/calendar" element={<MyCalendar />} />
                <Route path="/summary" element={<TrainingSummaryPage />} />
                <Route path="/" element={<Navigate to={"/calendar"} />} />
            </Routes>
        </BrowserRouter>
    );
};

export default App;