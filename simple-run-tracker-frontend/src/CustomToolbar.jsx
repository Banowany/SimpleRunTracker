// src/CustomToolbar.jsx
import React from 'react';
import { Button } from 'react-bootstrap';

const CustomToolbar = ({ onNavigate, label, onAddTraining, onAddPlannedTraining }) => {
    return (
        <div className="rbc-toolbar">
            <span className="rbc-btn-group">
                <Button onClick={() => onNavigate('TODAY')}>Today</Button>
                <Button onClick={() => onNavigate('PREV')}>Back</Button>
                <Button onClick={() => onNavigate('NEXT')}>Next</Button>
            </span>
            <span className="rbc-toolbar-label">{label}</span>
            <span className="rbc-btn-group">
                <Button onClick={onAddTraining}>Add Training</Button>
                <Button onClick={onAddPlannedTraining}>Add Planned Training</Button>
            </span>
        </div>
    );
};

export default CustomToolbar;