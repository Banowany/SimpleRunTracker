import React, { useState, useRef } from 'react';
import { Modal, Button, Form, Table } from 'react-bootstrap';

const AddPlannedTrainingModal = ({ show, handleClose, handleSave }) => {
    const [trainingType, setTrainingType] = useState('LONG');
    const [date, setDate] = useState('');
    const [comment, setComment] = useState('');
    const [segments, setSegments] = useState([{ name: '', plannedPaceInSecondsPerKm: '', planned_segment_type: 'time', plannedValue: '' }]);
    const [validated, setValidated] = useState(false);
    const formRef = useRef(null);

    const handleSegmentChange = (index, field, value) => {
        const newSegments = [...segments];
        newSegments[index][field] = value;
        setSegments(newSegments);
    };

    const handleAddSegment = () => {
        setSegments([...segments, { name: '', plannedPaceInSecondsPerKm: '', planned_segment_type: 'time', plannedValue: '' }]);
    };

    const resetForm = () => {
        setTrainingType('LONG');
        setDate('');
        setComment('');
        setSegments([{ name: '', plannedPaceInSecondsPerKm: '', planned_segment_type: 'time', plannedValue: '' }]);
        setValidated(false);
    };

    const handleSubmit = () => {
        const form = formRef.current;
        if (form.checkValidity() === false) {
            form.reportValidity();
        } else {
            const convertedSegments = segments.map(segment => {
                if (segment.planned_segment_type === 'time') {
                    return {
                        name: segment.name,
                        plannedPaceInSecondsPerKm: segment.plannedPaceInSecondsPerKm,
                        planned_segment_type: segment.planned_segment_type,
                        plannedDurationInSeconds: segment.plannedValue
                    };
                } else {
                    return {
                        name: segment.name,
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
            resetForm();
        }
        setValidated(true);
    };

    const handleModalClose = () => {
        handleClose();
        resetForm();
    };

    return (
        <Modal show={show} onHide={handleModalClose} size={"lg"}>
            <Modal.Header closeButton>
                <Modal.Title>Add Planned Training</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form noValidate validated={validated} ref={formRef}>
                    <Form.Group controlId="formTrainingType">
                        <Form.Label>Training Type</Form.Label>
                        <Form.Control as="select" value={trainingType}
                                      onChange={(e) => setTrainingType(e.target.value)} required>
                            <option value="LONG">LONG</option>
                            <option value="SPEED">SPEED</option>
                            <option value="THRESHOLD">THRESHOLD</option>
                            <option value="INTERVAL">INTERVAL</option>
                        </Form.Control>
                        <Form.Control.Feedback type="invalid">
                            Please select a training type.
                        </Form.Control.Feedback>
                    </Form.Group>
                    <Form.Group controlId="formDate">
                        <Form.Label>Date</Form.Label>
                        <Form.Control
                            type="date"
                            value={date}
                            onChange={(e) => setDate(e.target.value)} required
                        />
                        <Form.Control.Feedback type="invalid">
                            Please provide a valid date.
                        </Form.Control.Feedback>
                    </Form.Group>
                    <Form.Group controlId="formComment">
                        <Form.Label>Comment</Form.Label>
                        <Form.Control
                            type="text"
                            value={comment}
                            onChange={(e) => setComment(e.target.value)} required
                        />
                        <Form.Control.Feedback type="invalid">
                            Please provide a comment.
                        </Form.Control.Feedback>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Segments</Form.Label>
                        <Table striped bordered hover>
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Planned Pace (sec/km)</th>
                                <th>Goal</th>
                                <th>Value</th>
                            </tr>
                            </thead>
                            <tbody>
                            {segments.map((segment, index) => (
                                <tr key={index}>
                                    <td>{index + 1}</td>
                                    <td>
                                        <Form.Control
                                            type="text"
                                            value={segment.name}
                                            onChange={(e) => handleSegmentChange(index, 'name', e.target.value)} required
                                        />
                                        <Form.Control.Feedback type="invalid">
                                            Please provide a name.
                                        </Form.Control.Feedback>
                                    </td>
                                    <td>
                                        <Form.Control
                                            type="number"
                                            value={segment.plannedPaceInSecondsPerKm}
                                            onChange={(e) => handleSegmentChange(index, 'plannedPaceInSecondsPerKm', e.target.value)} required
                                        />
                                        <Form.Control.Feedback type="invalid">
                                            Please provide a planned pace.
                                        </Form.Control.Feedback>
                                    </td>
                                    <td>
                                        <Form.Control
                                            as="select"
                                            value={segment.planned_segment_type}
                                            onChange={(e) => handleSegmentChange(index, 'planned_segment_type', e.target.value)} required
                                        >
                                            <option value="time">TIME</option>
                                            <option value="distance">DISTANCE</option>
                                        </Form.Control>
                                        <Form.Control.Feedback type="invalid">
                                            Please select a goal type.
                                        </Form.Control.Feedback>
                                    </td>
                                    <td>
                                        <Form.Control
                                            type="number"
                                            value={segment.plannedValue}
                                            onChange={(e) => handleSegmentChange(index, 'plannedValue', e.target.value)} required
                                        />
                                        <Form.Control.Feedback type="invalid">
                                            Please provide a value.
                                        </Form.Control.Feedback>
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
                <Button variant="secondary" onClick={handleModalClose}>
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