import React, { useEffect, useState } from "react";
import { listAllUsers } from "../services/UserService";
import { deleteUser } from "../services/UserService";
import { useNavigate } from "react-router-dom";

const ListUserComponent = () => {
  const [users, setUsers] = useState([]);

  const navigator = useNavigate();
  useEffect(() => {
    getAllUsers();
  }, []);

  function getAllUsers() {
    listAllUsers()
      .then((response) => {
        setUsers(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  function addNewUser() {
    navigator("/add-user");
  }

  function updateUser(id) {
    navigator(`/update/${id}`); // backticks are used
  }

  function removeUser(id) {
    console.log(id);
    deleteUser(id)
      .then((response) => {
        console.log(response.data);
        getAllUsers();
      })
      .catch((error) => {
        console.log(error);
      });
  }

  return (
    <div className="container">
      <h2 className="text-center">List of Users</h2>
      <button
        type="button"
        className="btn btn-success mb-2"
        onClick={addNewUser}
      >
        Add User
      </button>
      <table className="table table-success table-striped table-bordered">
        <thead>
          <tr>
            <th>User Id</th>
            <th>User Name</th>
            <th>User Email</th>
            <th>User Password</th>
            <th>User Role</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <tr key={user.id}>
              <td>{user.id}</td>
              <td>{user.name}</td>
              <td>{user.email}</td>
              <td>{user.password}</td>
              <td>{user.role}</td>
              <td>
                <button
                  className="btn btn-info"
                  onClick={() => updateUser(user.id)}
                >
                  Update
                </button>

                <button
                  className="btn btn-danger"
                  style={{ marginLeft: "10px" }}
                  onClick={() => removeUser(user.id)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListUserComponent;
