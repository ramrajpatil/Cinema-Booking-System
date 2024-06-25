import React, { useEffect, useState } from "react";
import { addNewUser } from "../services/UserService";
import { getUserDetails } from "../services/UserService";
import { updateUser } from "../services/UserService";
import { useNavigate, useParams } from "react-router-dom";

const AddUserComponent = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [role, setRole] = useState("");

  const { id } = useParams(); // destructuring

  // Validation logic.
  const [errors, setErrors] = useState({
    name: "",
    email: "",
    password: "",
    role: "",
  });

  const navigator = useNavigate();

  useEffect(() => {
    if (id) {
      getUserDetails(id)
        .then((response) => {
          setName(response.data.name);
          setEmail(response.data.email);
          setPassword(response.data.password);
          setRole(response.data.role);
        })
        .catch((error) => {
          console.error(error);
          alert(error);
        });
    }
  }, [id]);

  const saveOrUpdateUser = (e) => {
    e.preventDefault();

    // validate form on submission.
    if (validateForm()) {
      const user = { name, email, password, role };
      console.log(user);

      if (id) {
        updateUser(id, user)
          .then((response) => {
            console.log(response.data);

            navigator("/users");
          })
          .catch((error) => {
            console.error(error);
          });
      } else {
        addNewUser(user)
          .then((response) => {
            console.log(response.data);
            navigator("/users"); // Navigating the user to list of users page.
          })
          .catch((error) => {
            console.error(error);
          });
      }
    }
  };

  function validateForm() {
    let valid = true;
    // copying errors variable into another variable.
    const errorsCopy = { ...errors };
    if (name.trim()) {
      errorsCopy.name = "";
    } else {
      errorsCopy.name = "Name cannot be empty !";
      valid = false;
    }
    if (email.trim()) {
      errorsCopy.email = "";
    } else {
      errorsCopy.email = "Email cannot be empty !";
      valid = false;
    }
    if (password.trim()) {
      errorsCopy.password = "";
    } else {
      errorsCopy.password = "password is required !";
      valid = false;
    }

    setErrors(errorsCopy);
    return valid;
  }

  function pageTitle() {
    if (id) {
      return <h2 className="text-center">Update User</h2>;
    } else {
      return <h2 className="text-center">Add User</h2>;
    }
  }

  return (
    <div className="container">
      <br />
      <br />
      <div className="row ">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          {pageTitle()}
          <div className="card-body">
            <form action="">
              <div className="form-group mb-2">
                <label className="form-lable">Name:</label>
                <input
                  type="text"
                  placeholder="Enter Name"
                  value={name}
                  className={`form-control ${errors.name ? "is-invalid" : ""}`}
                  onChange={(e) => setName(e.target.value)}
                />
                {/* Displaying validation */}
                {errors.name && (
                  <div className="invalid-feedback">{errors.name}</div>
                )}
              </div>
              <div className="form-group mb-2">
                <label className="form-lable">Email:</label>
                <input
                  type="email"
                  placeholder="Enter Email"
                  value={email}
                  className={`form-control ${errors.email ? "is-invalid" : ""}`}
                  onChange={(e) => setEmail(e.target.value)}
                />
                {/* Displaying validation */}
                {errors.email && (
                  <div className="invalid-feedback">{errors.email}</div>
                )}
              </div>
              <div className="form-group mb-2">
                <label className="form-lable">Password:</label>
                <input
                  type="password"
                  placeholder="Enter Password"
                  value={password}
                  className={`form-control ${
                    errors.password ? "is-invalid" : ""
                  }`}
                  onChange={(e) => setPassword(e.target.value)}
                />
                {/* Displaying validation */}
                {errors.password && (
                  <div className="invalid-feedback">{errors.password}</div>
                )}
              </div>
              <div className="form-group mb-2">
                <label className="form-lable">Role:</label>
                <input
                  type="text"
                  placeholder="Enter Password"
                  value={role}
                  className={`form-control ${
                    errors.role ? "is-invalid" : ""
                  }`}
                  onChange={(e) => setRole(e.target.value)}
                />
                {/* Displaying validation */}
                {errors.role && (
                  <div className="invalid-feedback">{errors.role}</div>
                )}
              </div>

              <button
                type="button"
                className="btn btn-success mb-2"
                onClick={saveOrUpdateUser}
              >
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddUserComponent;
