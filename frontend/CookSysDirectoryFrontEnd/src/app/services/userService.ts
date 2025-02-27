import { UserRequest } from "../models/userRequest";
import { fetchData } from "./fetchService";

export async function createUserFromRequest( userRequest :UserRequest){
    return fetchData({
    endpoint: `users`,
    method: "POST",
    body: JSON.stringify(userRequest),
    headers: {"Content-Type": "application/json"},
    }).then((response) => {
    if (response) {
        return response
    }
    else{
        console.log("creating user failed");
        return [];
    }

    }).catch(() => {
      console.log("creating user failed");
    return [];
    })
}