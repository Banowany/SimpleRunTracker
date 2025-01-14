import React, { useState } from 'react';
import { Modal, Button, Form, Table } from 'react-bootstrap';

const AddTrainingModal = ({ show, handleClose, handleSave }) => {
    const [trainingType, setTrainingType] = useState('LONG');
    const [date, setDate] = useState('');
    const [comment, setComment] = useState('');
    const [segments, setSegments] = useState([{ name: '', durationInSeconds: '', distanceInMeters: '', averageHeartRate: '' }]);

    const handleSegmentChange = (index, field, value) => {
        const newSegments = [...segments];
        newSegments[index][field] = value;
        setSegments(newSegments);
    };

    const addSegment = () => {
        setSegments([...segments, { name: '', durationInSeconds: '', distanceInMeters: '', averageHeartRate: '' }]);
    };

    const handleSubmit = () => {
        const newTraining = { trainingType, date, comment, segments };
        console.log(newTraining);
        handleSave(newTraining);
        handleClose();
    };

    return (
        <Modal show={show} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>Add Training</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form>
                    <Form.Group controlId="trainingType">
                        <Form.Label>Training Type</Form.Label>
                        <Form.Control as="select" value={trainingType}
                                      onChange={(e) => setTrainingType(e.target.value)}>
                            <option value="LONG">LONG</option>
                            <option value="SPEED">SPEED</option>
                            <option value="THRESHOLD">THRESHOLD</option>
                            <option value="INTERVAL">INTERVAL</option>
                        </Form.Control>
                    </Form.Group>
                    <Form.Group controlId="date">
                        <Form.Label>Date</Form.Label>
                        <Form.Control type="date" value={date} onChange={(e) => setDate(e.target.value)} />
                    </Form.Group>
                    <Form.Group controlId="comment">
                        <Form.Label>Comment</Form.Label>
                        <Form.Control type="text" value={comment} onChange={(e) => setComment(e.target.value)} />
                    </Form.Group>
                    <Form.Label>Segments</Form.Label>
                    <Table striped bordered hover>
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Duration (seconds)</th>
                            <th>Distance (meters)</th>
                            <th>Avg. Heart Rate</th>
                        </tr>
                        </thead>
                        <tbody>
                        {segments.map((segment, index) => (
                            <tr key={index}>
                                <td>
                                    <Form.Control type="text" value={segment.name} onChange={(e) => handleSegmentChange(index, 'name', e.target.value)} />
                                </td>
                                <td>
                                    <Form.Control type="number" value={segment.durationInSeconds} onChange={(e) => handleSegmentChange(index, 'durationInSeconds', e.target.value)} />
                                </td>
                                <td>
                                    <Form.Control type="number" value={segment.distanceInMeters} onChange={(e) => handleSegmentChange(index, 'distanceInMeters', e.target.value)} />
                                </td>
                                <td>
                                    <Form.Control type="number" value={segment.averageHeartRate} onChange={(e) => handleSegmentChange(index, 'averageHeartRate', e.target.value)} />
                                </td>
                            </tr>
                        ))}
                        </tbody>
                    </Table>
                    <Button variant="secondary" onClick={addSegment}>Add Segment</Button>
                </Form>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={handleClose}>Close</Button>
                <Button variant="primary" onClick={handleSubmit}>Save</Button>
            </Modal.Footer>
        </Modal>
    );
};

export default AddTrainingModal;