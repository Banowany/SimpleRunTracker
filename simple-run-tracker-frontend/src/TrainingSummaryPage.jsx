// src/components/TrainingSummaryPage.jsx
import React, { useState } from 'react';
import {Form, Button, Table, Row, Col} from 'react-bootstrap';
import ApiService from "./services/apiService.ts";

const apiService = new ApiService("http://localhost:8080");

const TrainingSummaryPage = () => {
    const [startDate, setStartDate] = useState('');
    const [endDate, setEndDate] = useState('');
    const [summary, setSummary] = useState(null);

    const handleGenerateSummary = () => {
        apiService.getTrainingSummary(startDate, endDate).then(response => {
            setSummary(response.data);
        });
    };

    return (
        <div style={{ padding: '20px', margin: '20px' }}>
            <h1>Training Summary</h1>
            <Form>
                <Row>
                    <Col>
                        <Form.Group controlId="startDate">
                            <Form.Label>Start Date</Form.Label>
                            <Form.Control type="date" value={startDate} onChange={(e) => setStartDate(e.target.value)} />
                        </Form.Group>
                    </Col>
                    <Col>
                        <Form.Group controlId="endDate">
                            <Form.Label>End Date</Form.Label>
                            <Form.Control type="date" value={endDate} onChange={(e) => setEndDate(e.target.value)} />
                        </Form.Group>
                    </Col>
                </Row>
                <Button variant="primary" onClick={handleGenerateSummary}>Generate Summary</Button>

            </Form>
            {summary && (
                <div>
                    <h2>Summary</h2>
                    <p>Total Training Count: {summary.totalTrainingCount}</p>
                    <p>Total Duration: {summary.totalDuration} seconds</p>
                    <p>Total Distance: {summary.totalDistance} meters</p>
                    <h3>Trainings</h3>
                    <Table striped bordered hover>
                        <thead>
                        <tr>
                            <th>Type</th>
                            <th>Date</th>
                            <th>Comment</th>
                        </tr>
                        </thead>
                        <tbody>
                        {summary.trainings.map((training) => (
                            <tr key={training.id}>
                                <td>{training.trainingType}</td>
                                <td>{training.date}</td>
                                <td>{training.comment}</td>
                            </tr>
                        ))}
                        </tbody>
                    </Table>
                </div>
            )}
        </div>
    );
};

export default TrainingSummaryPage;