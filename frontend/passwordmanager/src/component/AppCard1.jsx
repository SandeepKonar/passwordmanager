import React, { useState } from "react";
import DeleteIcon from '@material-ui/icons/Delete';
import EditIcon from '@material-ui/icons/Edit';
import OpenWithIcon from '@material-ui/icons/OpenWith';
import VisibilityIcon from '@material-ui/icons/Visibility';
import VisibilityOffIcon from '@material-ui/icons/VisibilityOff';
import { API } from "../util/constants";
import { useDispatch, useSelector } from "react-redux";
import { webClient } from "../util/config";
import { updateUser } from "../redux/slices/userSlice";

const AppCard1 = ({ appName, appPassword, handleDeleteApp }) => {
    const user = useSelector(store => store.user);
    const maskedAppPassword= appPassword!=null?"**********":"";
    const [isVisible, setVisible] = useState(false);
    const dispatch = useDispatch();

    function handleDeleteApp(){
        const req = {
            "username": user.username,
            "appName": appName,

        }
        console.log("entered handleDelete : "  +appName);
        webClient.post(API.ENDPOINT_DELETE_APP, req)
        .then(resp => {
          console.log(`${appName} deleted successfully`);
          dispatch(updateUser(resp.data));
          console.log(resp);
        }).catch(err => {
          console.log(err);
        });
    }   
    return  <div className="col mb-4 app-card">
                <div className="card h-100">
                    <div className="d-flex flex-row-reverse gap-2 icon">
                        <button  className="btn rounded-circle b-0" onClick={handleDeleteApp}><DeleteIcon/></button>
                        {/* <button  className="btn rounded-circle b-0"><EditIcon/></button> */}
                    </div>
                    <div className="card-body">
                        <h5>App Name : {appName}</h5><hr/>
                        <div className="eye-container eye-icon"> 
                            <h6>Password  : {isVisible?appPassword:maskedAppPassword} </h6>
                            <button className="btn rounded-circle b-0" onClick={() => setVisible(prev=> !prev)}>
                                {isVisible?<VisibilityIcon/>:<VisibilityOffIcon/>}
                            </button>
                        </div>
                    </div>
                    <div className="apps-footer icon">
                        <button  className="btn rounded-circle b-0"><OpenWithIcon/></button>
                    </div>
                </div>
            </div>
        
};

export default AppCard1;