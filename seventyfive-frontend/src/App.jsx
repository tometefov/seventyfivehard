import { useEffect, useState } from "react";
import "./App.css";

function App() {
    const [day, setDay] = useState(null);

    const loadStatus = () => {
        fetch("http://localhost:8080/api/day/")
            .then(res => res.json())
            .then(data => setDay(data));
    };

    useEffect(() => {
        loadStatus();
    }, []);

    const toggleTask = (id) => {
        fetch(`http://localhost:8080/api/tasks/${id}/toggle`, {
            method: "PUT"
        })
            .then(res => res.json())
            .then(() => loadStatus());
    };

    const nextDay = () => {
        fetch("http://localhost:8080/api/day/next", {
            method: "POST"
        })
            .then(res => res.json())
            .then(data => setDay(data));
    };

    if (!day) return <div>Loading...</div>;

    const progressPercent = (day.currentDay / 75) * 100;
    const remaining = 75 - day.currentDay;

    return (
        <div className="app">
            <header>
                <h1>75Hard Challenge</h1>
                <p className="subtitle">
                    Discipline. Consistency. Mental Toughness.
                </p>
            </header>

            <section className="day-box">
                <h2>Day {day.currentDay} / 75</h2>

                <div className="progress">
                    <div
                        className="progress-fill"
                        style={{ width: `${progressPercent}%` }}
                    ></div>
                </div>

                <p className="remaining">
                    {remaining} days remaining
                </p>
            </section>

            <section className="tasks">
                <h3>Daily Tasks</h3>

                {day.tasks.map(task => (
                    <div
                        key={task.id}
                        className={`task ${task.completed ? "completed" : ""}`}
                        onClick={() => toggleTask(task.id)}
                    >
            <span >
              {task.completed ? "✔ " : "✗ "}
                {task.name}
            </span>
                    </div>
                ))}
            </section>

            <button className="next-day" onClick={nextDay}>
                Proceed to Next Day
            </button>
        </div>
    );
}

export default App;
