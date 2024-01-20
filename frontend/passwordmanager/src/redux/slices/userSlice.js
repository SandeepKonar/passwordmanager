import { createSlice } from "@reduxjs/toolkit";

const initialStateValue = {};

const userSlice = createSlice({
    name: 'User',
    initialState: initialStateValue,
    reducers: {
        login: (state, action) => {
            return action.payload;
        },
        logout: (state, action) => {
            return initialStateValue;
        }
    }
})
export const {login, logout} = userSlice.actions;
export default userSlice.reducer;