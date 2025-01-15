import React, { useState, useRef } from 'react';
import { Modal, Button, Form, Table } from 'react-bootstrap';

const AddTrainingModal = ({ show, handleClose, handleSave }) => {
    const [trainingType, setTrainingType] = useState('LONG');
    const [date, setDate] = useState('');
    const [comment, setComment] = useState('');
    const [segments, setSegments] = useState([{ name: '', durationInSeconds: '', distanceInMeters: '', averageHeartRate: '' }]);
    const [validated, setValidated] = useState(false);
    const formRef = useRef(null);

    const handleSegmentChange = (index, field, value) => {
        const newSegments = [...segments];
        newSegments[index][field] = value;
        setSegments(newSegments);
    };

    const addSegment = () => {
        setSegments([...segments, { name: '', durationInSeconds: '', distanceInMeters: '', averageHeartRate: '' }]);
    };

    const resetForm = () => {
        setTrainingType('LONG');
        setDate('');
        setComment('');
        setSegments([{ name: '', durationInSeconds: '', distanceInMeters: '', averageHeartRate: '' }]);
        setValidated(false);
    };

    //map segments to segments where empty strings are replaced with null
    const mapSegments = (segments) => {
        return segments.map(segment => {
            return {
                name: segment.name === '' ? null : segment.name,
                durationInSeconds: segment.durationInSeconds,
                distanceInMeters: segment.distanceInMeters,
                averageHeartRate: segment.averageHeartRate === '' ? null : segment.averageHeartRate
            };
        });
    }

    const handleSubmit = () => {
        const form = formRef.current;
        if (form.checkValidity() === false) {
            form.reportValidity();
        } else {
            const newTraining = {
                trainingType,
                date,
                comment: comment===''?null:comment,
                segments: mapSegments(segments)
            };
            handleSave(newTraining);
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
                <Modal.Title>Add Training</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form noValidate validated={validated} ref={formRef}>
                    <Form.Group controlId="trainingType">
                        <Form.Label>Training Type</Form.Label>
                        <Form.Control as="select" value={trainingType} onChange={(e) => setTrainingType(e.target.value)} required>
                            <option value="LONG">LONG</option>
                            <option value="SPEED">SPEED</option>
                            <option value="THRESHOLD">THRESHOLD</option>
                            <option value="INTERVAL">INTERVAL</option>
                        </Form.Control>
                        <Form.Control.Feedback type="invalid">
                            Please select a training type.
                        </Form.Control.Feedback>
                    </Form.Group>
                    <Form.Group controlId="date">
                        <Form.Label>Date</Form.Label>
                        <Form.Control type="date" value={date} onChange={(e) => setDate(e.target.value)} required />
                        <Form.Control.Feedback type="invalid">
                            Please provide a valid date.
                        </Form.Control.Feedback>
                    </Form.Group>
                    <Form.Group controlId="comment">
                        <Form.Label>Comment</Form.Label>
                        <Form.Control type="text" value={comment} onChange={(e) => setComment(e.target.value)} />
                    </Form.Group>
                    <Form.Label>Segments</Form.Label>
                    <Table striped bordered hover>
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Duration (seconds)</th>
                            <th>Distance (meters)</th>
                            <th>Avg. Heart Rate</th>
                        </tr>
                        </thead>
                        <tbody>
                        {segments.map((segment, index) => (
                            <tr key={index}>
                                <td>{index + 1}</td>
                                <td>
                                    <Form.Control type="text" value={segment.name} onChange={(e) => handleSegmentChange(index, 'name', e.target.value)} />
                                </td>
                                <td>
                                    <Form.Control type="number" value={segment.durationInSeconds} onChange={(e) => handleSegmentChange(index, 'durationInSeconds', e.target.value)} required />
                                    <Form.Control.Feedback type="invalid">
                                        Please provide a duration.
                                    </Form.Control.Feedback>
                                </td>
                                <td>
                                    <Form.Control type="number" value={segment.distanceInMeters} onChange={(e) => handleSegmentChange(index, 'distanceInMeters', e.target.value)} required />
                                    <Form.Control.Feedback type="invalid">
                                        Please provide a distance.
                                    </Form.Control.Feedback>
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
                <Button variant="secondary" onClick={handleModalClose}>Close</Button>
                <Button variant="primary" onClick={handleSubmit}>Save</Button>
            </Modal.Footer>
        </Modal>
    );
};

export default AddTrainingModal;