import {useEffect, useState} from "react";
import TrainingService from "./services/trainingService.ts";

function TrainingList() {
    const [data, setData] = useState([])

    const trainingService = new TrainingService("http://localhost:8080")

    useEffect(() => {
        trainingService.getTrainings().then(response => {
            setData(response.data)
        })
    }, [])

    return (
        <ul>
            {data.map(training => (
                <li key={training.id}>
                    {training.comment}
                </li>
            ))}
        </ul>
    );
}

export default TrainingList;