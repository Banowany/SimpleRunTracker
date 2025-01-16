# How to run
## Requirements
- Docker
- Gradle
- JDK 17
- Node.js
- npm
## Process
1. Run this command to start the PostgreSQL database container
```bash
docker run --name postgres-database  -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres
```
2. Run the backend service using these commands
```bash
cd simple-run-tracker-backend
gradle bootRun
```

3. Run the frontend service using these commands
```bash
cd simple-run-tracker-frontend
npm install
npm run dev
```

# Description
The Simple Training Tracker application allows the user to manage workouts and generate summaries of completed training sessions. With the calendar, the user can easily see scheduled and completed workouts, as well as add new workouts to their schedule. The summary section allows generating a report for a selected period.

# User interface
- Top navigation bar:
    - Located at the top of every page of the application.
    - Contains links to the sections: "Calendar" and "Summary".
- Home Page (Calendar Section)
    - Displays the calendar and a list of completed and planned workouts.
    - Green color represents completed and purple represents planned workouts.
    - Next to the calendar, there are buttons:
        - "Today", "Back", "Next" for navigating the calendar.
        - "Add Training" for adding completed workouts.
        - "Add Planned Training" for planning a workout.
    - Next to each workout on the list, there is a "Details" button.
- Workout Details
    - After clicking on a workout in the calendar or the "Details" button in the list.
    - Shows data such as workout type, comment, and segment details.
- Adding a Workout
    - After clicking the "Add Training" button.
    - The user fills in the workout data.
    - Mandatory fields are:
        - Workout type
        - Date
        - Distance in segments
        - Time in segments
- Planning a Workout
    - After clicking the "Add Planned Training" button.
    - The user fills in the parameters of the planned workout.
    - Mandatory fields are:
        - Workout type
        - Date
        - Goal in segments
        - Value in segments, which represents seconds or meters depending on the selected goal.
- Generating Summaries
    - After clicking "Summary" in the navigation bar.
    - Has two date fields representing the range for which we want the summary and a "Generate Summary" button.
    - After clicking "Generate Summary", it is displayed below.

# Usage examples
- Adding a new workout
    - Go to the calendar section and click the Add Training button.
    - In the displayed form, fill in the requested data.
    - After filling in all the data, click "Save". The workout will appear on the calendar and on the list.
- Adding a planned workout
    - Go to the calendar section and click the Add Planned Training button.
    - In the displayed form, fill in the requested data.
    - After filling in all the data, click "Save". The planned workout will appear on the calendar and on the list.
- Viewing workout details:
    - Click on any workout in the calendar or select the Details button next to the workout on the list.
    - A modal window will open with full details of the selected workout, such as date, workout type, notes, etc.
- Generating a summary:
    - Go to the Summary section by clicking the appropriate link in the navbar.
    - Select the date range you are interested in using the date picker fields.
    - Click the Generate Summary button. The system will generate a report of the workouts completed in the selected period.

# Patterns
- Service layer
    - CompletedTrainingService, PlannedTrainingService, TrainingSummaryService
    - why is used: To consolidate business logic in one place for easier modification and readability.
- Data Mapper
    - Training, CompletedTraining, PlannedTraining
    - Segment, CompletedSegment, PlannedSegment, PlannedDistanceSegment, PlannedTimeSegment
    - why is used: To transform objects into database data without using traditional SQL.
- Identity Field
    - Training, CompletedTraining, PlannedTraining
    - Segment, CompletedSegment, PlannedSegment, PlannedDistanceSegment, PlannedTimeSegment
    - why is used: To simplify subsequent CRUD operations.
- Foreign Key Mapping
    - Training, Segment
    - why is used: To define relationships between entities for easier data manipulation.
- Single Table Inheritance
    - Training, CompletedTraining, PlannedTraining
    - Segment, CompletedSegment, PlannedSegment, PlannedDistanceSegment, PlannedTimeSegment
    - why is used: To store different types of related entities in a single table.
- Repository
    - CompletedTrainingRepository, PlannedTrainingRepository
    - why is used: To abstract data access and provide a centralized data handling mechanism.
- Model View Controller
    - Spring: Model and Controller
    - React: View
    - why is used: To separate concerns and improve code maintainability.
- Front Controller - automatically handled
    - CompletedTrainingController, PlannedTrainingController, TrainingSummaryController
    - why is used: To handle all incoming requests through a single entry point.
- Data Transfer Object
    - TrainingSummary
    - CompletedTrainingDTO, CompletedSegmentDTO
    - PlannedTrainingDTO, PlannedSegmentDTO
    - why is used: To transfer data between layers without exposing the underlying entities.
- Mapper
    - CompletedSegmentMapper, CompletedTrainingMapper
    - PlannedSegmentMapper, PlannedTrainingMapper
    - why is used: To convert between DTOs and entities.

# Class Diagram
![alt uml_diagram_image](main.png)