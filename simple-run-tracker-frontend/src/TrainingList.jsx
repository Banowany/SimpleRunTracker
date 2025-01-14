import React, { forwardRef, useImperativeHandle } from 'react';
import { ListGroup, Card, Button } from 'react-bootstrap';
import moment from 'moment';

const TrainingList = forwardRef(({ trainings, plannedTrainings, onDetailsClick }, ref) => {
    const converted_trainings = trainings.map(training => ({
        ...training,
        isPlanned: false,
    }));
    const converted_planned_trainings = plannedTrainings.map(training => ({
        ...training,
        isPlanned: true,
    }));
    const allTrainings = [...converted_trainings, ...converted_planned_trainings];

    allTrainings.sort((a, b) => moment(b.date) - moment(a.date));

    const groupedTrainings = allTrainings.reduce((acc, training) => {
        const date = moment(training.date).format('YYYY-MM-DD');
        if (moment(date, 'YYYY-MM-DD', true).isValid()) {
            if (!acc[date]) {
                acc[date] = [];
            }
            acc[date].push(training);
        }
        return acc;
    }, {});

    useImperativeHandle(ref, () => ({
        scrollToDate(date) {
            const element = document.getElementById(date);
            if (element) {
                element.scrollIntoView({ behavior: 'smooth' });
            }
        }
    }));

    return (
        <div>
            {Object.keys(groupedTrainings).sort((a, b) => b.localeCompare(a)).map(date => (
                <Card key={date} id={date} className="mt-3">
                    <Card.Header>{date}</Card.Header>
                    <ListGroup variant="flush">
                        {groupedTrainings[date].map((training, index) => (
                            <ListGroup.Item key={index} className="d-flex justify-content-between align-items-center">
                                <div>
                                    <strong>Type:</strong> {training.trainingType} <br />
                                    <strong>Comment:</strong> {training.comment} <br />
                                    <strong>Planned:</strong> {training.isPlanned ? 'Yes' : 'No'}
                                </div>
                                <Button variant="secondary" onClick={() => onDetailsClick(training)}>
                                    Details
                                </Button>
                            </ListGroup.Item>
                        ))}
                    </ListGroup>
                </Card>
            ))}
        </div>
    );
});

export default TrainingList;