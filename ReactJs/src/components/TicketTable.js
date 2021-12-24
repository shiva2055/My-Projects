import React, { useState } from "react";
import './css/TicketTable.css';
import defaultTable from './mock-data.json';
import { useLocation } from 'react-router-dom';

function TicketTable() {
  const location = useLocation()
  console.log(location)
  const [table, setTable] = useState(() => {
    try {
      const value = sessionStorage.getItem('tableStorage');

      if (value) return JSON.parse(value);
      else {
        sessionStorage.setItem('tableStorage', JSON.stringify(defaultTable));
        return defaultTable;
      }
    } catch (err) {
      console.log("problem with value");
    }
  });

  const handleAddTicketSubmit = (event) => {
    event.preventDefault();

    console.log("hello");
    const newRow = newTicketRow(document.getElementById('desc').value);
    const updatedTable = [...table, newRow];
    console.log(newRow)

    sessionStorage.setItem('tableStorage', JSON.stringify(updatedTable));
    setTable(JSON.parse(sessionStorage.getItem('tableStorage')));
  }

  const newTicketRow = (desc) => {
    const row = {
      id: table.at(-1).id + 1,
      date: getTodaysDate(),
      status: "Received",
      description: desc
    };

    return row;
  }

  const getTodaysDate = () => {
    var today = new Date();
    var dd = String(today.getDate() + 2).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();
    today = mm + '/' + dd + '/' + yyyy;
    return today;
  }

  return <div className="app-container">
    <table className="table">
      <thead>
        <tr id="row">
          <th className="header">Ticket ID</th>
          <th className="header">Date</th>
          <th className="header">Status</th>
          <th className="header">Description</th>
        </tr>
      </thead>
      <tbody>
        {table.map((row) => (
          <tr>
            <td className="data">{row.id}</td>
            <td className="data">{row.date}</td>
            <td className="data">{row.status}</td>
            <td className="data">{row.description}</td>
          </tr>
        ))}
      </tbody>
    </table>

    <form onSubmit={handleAddTicketSubmit} >
      <input
        id="desc"
        type="text"
        name="description"
        placeholder="Describe the problem..."
      />
      <button type="submit">Add</button>
    </form>
  </div>;
};
export default TicketTable;



