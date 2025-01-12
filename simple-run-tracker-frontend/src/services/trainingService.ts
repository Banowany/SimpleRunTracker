import axios, {AxiosInstance} from "axios";
import {TrainingDTO} from "../dtos/training.dto";

class TrainingService {
    private client: AxiosInstance;

    constructor(baseURL: string) {
        this.client = axios.create({
            baseURL: baseURL,
        })
    }

    getTrainings() : Promise<TrainingDTO[]> {
        return this.client.get("/api/trainings")
    }
}

export default TrainingService;