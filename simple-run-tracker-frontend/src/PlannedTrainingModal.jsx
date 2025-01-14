// src/PlannedTrainingModal.jsx
import React from 'react';
import { Modal, Button, Table } from 'react-bootstrap';

const PlannedTrainingModal = ({ show, handleClose, training }) => {
    console.log(training);
    return (
        <Modal show={show} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>Planned Training Details</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <p><strong>Type:</strong> {training.trainingType}</p>
                <p><strong>Date:</strong> {training.date}</p>
                <p><strong>Comment:</strong> {training.comment}</p>
                <p><strong>Segments:</strong></p>
                <Table striped bordered hover>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Planned Pace (sec/km)</th>
                        <th>Planned Distance or Time</th>
                    </tr>
                    </thead>
                    <tbody>
                    {training.segments.map((segment, index) => (
                        <tr key={index + 1}>
                            <td>{index + 1}</td>
                            <td>{segment.name}</td>
                            <td>{segment.plannedPaceInSecondsPerKm}</td>
                            <td>
                                {segment.planned_segment_type === 'time' && `${segment.plannedDurationInSeconds} sec`}
                                {segment.planned_segment_type === 'distance' && `${segment.plannedDistanceInMeters} meters`}
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </Table>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={handleClose}>
                    Close
                </Button>
            </Modal.Footer>
        </Modal>
    );
};

export default PlannedTrainingModal;