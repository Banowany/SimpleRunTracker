import React, { useState } from 'react';
import { Modal, Button, Form, Table } from 'react-bootstrap';

const AddPlannedTrainingModal = ({ show, handleClose, handleSave }) => {
    const [trainingType, setTrainingType] = useState('');
    const [date, setDate] = useState('');
    const [comment, setComment] = useState('');
    const [segments, setSegments] = useState([]);

    const handleAddSegment = () => {
        setSegments([...segments, { plannedPaceInSecondsPerKm: '', planned_segment_type: 'time', plannedValue: '' }]);
    };

    const handleSegmentChange = (index, field, value) => {
        const newSegments = [...segments];
        newSegments[index][field] = value;
        setSegments(newSegments);
    };

    const handleSubmit = () => {
        const convertedSegments = segments.map(segment => {
            if (segment.planned_segment_type === 'time') {
                return {
                    plannedPaceInSecondsPerKm: segment.plannedPaceInSecondsPerKm,
                    planned_segment_type: segment.planned_segment_type,
                    plannedDurationInSeconds: segment.plannedValue
                };
            } else {
                return {
                    plannedPaceInSecondsPerKm: segment.plannedPaceInSecondsPerKm,
                    planned_segment_type: segment.planned_segment_type,
                    plannedDistanceInMeters: segment.plannedValue
                };
            }
        });
        const newPlannedTraining = {
            trainingType,
            date,
            comment,
            segments: convertedSegments
        };
        handleSave(newPlannedTraining);
        handleClose();
    };

    return (
        <Modal show={show} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>Add Planned Training</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form>
                    <Form.Group controlId="formTrainingType">
                        <Form.Label>Training Type</Form.Label>
                        <Form.Control
                            type="text"
                            value={trainingType}
                            onChange={(e) => setTrainingType(e.target.value)}
                        />
                    </Form.Group>
                    <Form.Group controlId="formDate">
                        <Form.Label>Date</Form.Label>
                        <Form.Control
                            type="date"
                            value={date}
                            onChange={(e) => setDate(e.target.value)}
                        />
                    </Form.Group>
                    <Form.Group controlId="formComment">
                        <Form.Label>Comment</Form.Label>
                        <Form.Control
                            type="text"
                            value={comment}
                            onChange={(e) => setComment(e.target.value)}
                        />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Segments</Form.Label>
                        <Table striped bordered hover>
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Planned Pace (sec/km)</th>
                                <th>Type</th>
                                <th>Value</th>
                            </tr>
                            </thead>
                            <tbody>
                            {segments.map((segment, index) => (
                                <tr key={index}>
                                    <td>{index + 1}</td>
                                    <td>
                                        <Form.Control
                                            type="number"
                                            value={segment.plannedPaceInSecondsPerKm}
                                            onChange={(e) => handleSegmentChange(index, 'plannedPaceInSecondsPerKm', e.target.value)}
                                        />
                                    </td>
                                    <td>
                                        <Form.Control
                                            as="select"
                                            value={segment.planned_segment_type}
                                            onChange={(e) => handleSegmentChange(index, 'planned_segment_type', e.target.value)}
                                        >
                                            <option value="time">Time</option>
                                            <option value="distance">Distance</option>
                                        </Form.Control>
                                    </td>
                                    <td>
                                        <Form.Control
                                            type="number"
                                            value={segment.plannedValue}
                                            onChange={(e) => handleSegmentChange(index, 'plannedValue', e.target.value)}
                                        />
                                    </td>
                                </tr>
                            ))}
                            </tbody>
                        </Table>
                        <Button variant="secondary" onClick={handleAddSegment}>
                            Add Segment
                        </Button>
                    </Form.Group>
                </Form>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={handleClose}>
                    Close
                </Button>
                <Button variant="primary" onClick={handleSubmit}>
                    Save
                </Button>
            </Modal.Footer>
        </Modal>
    );
};

export default AddPlannedTrainingModal;