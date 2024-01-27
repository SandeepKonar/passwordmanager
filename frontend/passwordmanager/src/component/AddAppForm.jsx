import React, { useState } from "react";
import { Input } from "./Input";
import AddAppPropTable from "./AddAppPropTable";
import { useDispatch, useSelector } from "react-redux";
import { webClient } from "../util/config";
import { API } from "../util/constants";
import { updateUser } from "../redux/slices/userSlice";
import { Form, useNavigate } from "react-router-dom";
const AddApp = () => {
  const [app, saveApp] = useState({
    name: '',
    password: '',
    additionalProperties: []
  })

  const user = useSelector(store => store.user);
  const [rowCount, setRowCount] = useState(0);
  const dispatch = useDispatch();

  const onAddAppSubmit = () => {
    if (app) {
      const req = {
        username: user.username,
        app: app
      }
      webClient.post(API.ENDPOINT_ADD_APP, req)
        .then(resp => {
          console.log(`${app.name} added successfully`);
          dispatch(updateUser(resp.data));
          var modalElement = document.getElementById('addAppModal');
          var modal = bootstrap.Modal.getInstance(modalElement);
          modal.hide();
        }).catch(err => {
          console.log(err);
        });

    } else {
      console.log("app details empty");
    }
  }

  const onFormChange = (event) => {
    saveApp({ ...app, [event.target.name]: event.target.value });
  }

  return (
    <div className="modal modal-xl fade" id="addAppModal" tabIndex="-1" aria-labelledby="addAppModal" aria-hidden="true">
      <div className="modal-dialog">
        <div className="modal-content">
          <div className="modal-header">
            <h1 className="modal-title fs-5" id="addAppModalLabel">Add Application</h1>
            <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div className="modal-body">
            <label className='form-label' htmlFor="appName">Application Name </label>
            <input className='form-control' name="name" type='text' value={app.name} onChange={onFormChange} />
            <label className='form-label' htmlFor="password">Password </label>
            <input className='form-control' name="password" type='password' value={app.password} onChange={onFormChange} />
            <label className='form-label' htmlFor="confirmPassword">Confirm Password </label>
            <input className='form-control' name="confirmPassword" type='password' />
            <button type="button" className="btn btn-outline-primary mt-2" onClick={() => setRowCount(prevCount => prevCount + 1)}>Additional Properties</button>
            <AddAppPropTable rowCount={rowCount} />
          </div>
          <div className="modal-footer">
            <button type="button" className="btn btn-primary" onClick={onAddAppSubmit}>Add</button>
            <button type="button" className="btn btn-secondary" data-bs-dismiss="modal" onClick={() => setRowCount(0)}>Cancel</button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddApp;