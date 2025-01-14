import axios, {AxiosInstance} from "axios";
import {TrainingDTO} from "../dtos/training.dto";
import {TrainingSummaryDto} from "../dtos/trainingSummary.dto";

class ApiService {
    private client: AxiosInstance;

    constructor(baseURL: string) {
        this.client = axios.create({
            baseURL: baseURL,
        })
    }

    getTrainings() : Promise<TrainingDTO[]> {
        return this.client.get("/api/trainings")
    }

    addTraining(training: TrainingDTO) : Promise<TrainingDTO> {
        return this.client.post("/api/trainings", training)
    }

    getTrainingSummary(from, to) : Promise<TrainingSummaryDto> {
        return this.client.get("/api/trainingSummary", {
            params: {
                startDate: from,
                endDate: to
            }
        })
    }
}

export default ApiService;