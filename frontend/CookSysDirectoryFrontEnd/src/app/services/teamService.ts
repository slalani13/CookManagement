import { fetchData } from "./fetchService";
import { teamRequestData } from "../models/teamData";
import { credentialsData } from "../models/credentialsData";

export async function getTeamsOfCompany(company_id:number){
    return fetchData({
    endpoint: `teams/company/${company_id}`,
    }).then((response) => {
    if (response) {
        return response
    }
    else{
        console.log("getting projects failed for team id: "+company_id);
        return [];
    }

    }).catch(() => {
    console.log("getting teams failed for team id: "+company_id);
    return [];
    })
}

export async function getAllTeams(){
    return fetchData({
    endpoint: `teams`,
    }).then((response) => {
    if (response) {
        return response
    }
    else{
        console.log("getting all teams failed");
        return [];
    }

    }).catch(() => {
    console.log("getting all teams failed");
    return [];
    })
}


export async function createTeam(team_id:number, teamRequest:teamRequestData){
    return fetchData({
    endpoint: `teams`,
    method: "POST",
    body: JSON.stringify(teamRequest),
    headers: {"Content-Type": "application/json"},
    }).then((response) => {
    if (response) {
        return response
    }
    else{
        console.log("creating team failed for team id: "+team_id);
        return [];
    }

    }).catch(() => {
    console.log("creating team failed failed for team id: "+team_id);
    return [];
    })
}

export async function updateTeam(team_id:number, teamRequest:teamRequestData){
    return fetchData({
    endpoint: `teams/${team_id}/update`,
    method: "PATCH",
    body: JSON.stringify(teamRequest),
    headers: {"Content-Type": "application/json"},
    }).then((response) => {
    if (response) {
        return response
    }
    else{
        console.log("updating team failed for team id: "+team_id);
        return [];
    }

    }).catch(() => {
    console.log("updating team failed for team id: "+team_id);
    return [];
    })
}

export async function addToTeam(team_id:number, user_id:number, credentialsRequest: credentialsData){
    return fetchData({
    endpoint: `teams/${team_id}/add/${user_id}`,
    method: "PATCH",
    body: JSON.stringify(credentialsRequest),
    headers: {"Content-Type": "application/json"},
    }).then((response) => {
    if (response) {
        return response
    }
    else{
        console.log("updating (add) team failed for team id: "+team_id);
        return [];
    }

    }).catch(() => {
    console.log("updating (add) team failed for team id: "+team_id);
    return [];
    })
}

export async function removeFromTeam(team_id:number, user_id:number, credentialsRequest: credentialsData){
    return fetchData({
    endpoint: `teams/${team_id}/remove/${user_id}`,
    method: "PATCH",
    body: JSON.stringify(credentialsRequest),
    headers: {"Content-Type": "application/json"},
    }).then((response) => {
    if (response) {
        return response
    }
    else{
        console.log("updating (remove) team failed for team id: "+team_id);
        return [];
    }

    }).catch(() => {
    console.log("updating (remove) team failed for team id: "+team_id);
    return [];
    })
}

export async function deleteTeam(team_id:number, credentialsRequest: credentialsData){
    return fetchData({
    endpoint: `teams/${team_id}`,
    method: "DELETE",
    body: JSON.stringify(credentialsRequest),
    headers: {"Content-Type": "application/json"},
    }).then((response) => {
    if (response) {
        return response
    }
    else{
        console.log("updating project failed for project id: "+team_id);
        return [];
    }

    }).catch(() => {
    console.log("updating project failed for project id: "+team_id);
    return [];
    })
}