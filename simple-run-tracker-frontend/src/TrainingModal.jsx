// import React, { useState } from 'react';
import {Modal, Button, Table} from 'react-bootstrap';

const TrainingModal = ({ show, handleClose, training }) => {
    return (
        <Modal show={show} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>Training Details</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <p><strong>Type:</strong> {training.trainingType}</p>
                <p><strong>Date:</strong> {training.date}</p>
                <p><strong>Comment:</strong> {training.comment}</p>
                <p><strong>Segments:</strong></p>
                <Table>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Duration</th>
                        <th>Distance</th>
                        <th>Avg. Pace</th>
                    </tr>
                    </thead>
                    <tbody>
                        {training.segments.map((segment, index) => (
                            <tr key={index}>
                                <td>{index + 1}</td>
                                <td>{segment.name}</td>
                                <td>{segment.durationInSeconds}</td>
                                <td>{segment.distanceInMeters}</td>
                                <td>{segment.averageHeartRate}</td>
                            </tr>
                        ))}
                    </tbody>

                </Table>

                {/*<ul>*/}
                {/*    {training.segments.map((segment, index) => (*/}
                {/*        <li key={index}>{segment.name}</li>*/}
                {/*    ))}*/}
                {/*</ul>*/}
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={handleClose}>
                    Close
                </Button>
            </Modal.Footer>
        </Modal>
    );
};

export default TrainingModal;