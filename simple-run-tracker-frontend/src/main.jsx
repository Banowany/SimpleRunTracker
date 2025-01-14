import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import 'bootstrap/dist/css/bootstrap.min.css';
// import './index.css'
// import App from './App.jsx'
// import TrainingList from "./TrainingList.jsx";
// import CalendarTest from "./MyCalendar.jsx";
import TrainingSummaryPage from "./TrainingSummaryPage.jsx";

createRoot(document.getElementById('root')).render(
  <StrictMode>
    {/*<TrainingList />*/}
    {/*<CalendarTest></CalendarTest>*/}
      <TrainingSummaryPage></TrainingSummaryPage>
  </StrictMode>,
)
