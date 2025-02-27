import { fetchData } from "./fetchService";
import { projectData } from "../models/projectData";
import { credentialsData } from "../models/credentialsData";

export async function getProjectsFromTeam(team_id:number){
    return fetchData({
    endpoint: `projects/teams/${team_id}`,
    }).then((response) => {
    if (response) {
        return response
    }
    else{
        console.log("getting projects failed for team id: "+team_id);
        return [];
    }

    }).catch(() => {
    console.log("getting projects failed for team id: "+team_id);
    return [];
    })
}

export async function getAllProjects(){
    return fetchData({
    endpoint: `projects`,
    }).then((response) => {
    if (response) {
        return response
    }
    else{
        console.log("getting all projects failed");
        return [];
    }

    }).catch(() => {
    console.log("getting all projects failed");
    return [];
    })
}


export async function createProject(team_id:number, projectRequest:projectData){
    return fetchData({
    endpoint: `projects/teams/${team_id}`,
    method: "POST",
    body: JSON.stringify(projectRequest),
    headers: {"Content-Type": "application/json"},
    }).then((response) => {
    if (response) {
        return response
    }
    else{
        console.log("creating project failed for team id: "+team_id);
        return [];
    }

    }).catch(() => {
    console.log("creating project failed failed for team id: "+team_id);
    return [];
    })
}

export async function updateProject(project_id:number, projectRequest:projectData){
    return fetchData({
    endpoint: `${project_id}`,
    method: "PATCH",
    body: JSON.stringify(projectRequest),
    headers: {"Content-Type": "application/json"},
    }).then((response) => {
    if (response) {
        return response
    }
    else{
        console.log("updating project failed for project id: "+project_id);
        return [];
    }

    }).catch(() => {
    console.log("updating project failed for project id: "+project_id);
    return [];
    })
}

export async function deleteProject(project_id:number, credentialsRequest: credentialsData){
    return fetchData({
    endpoint: `${project_id}`,
    method: "DELETE",
    body: JSON.stringify(credentialsRequest),
    headers: {"Content-Type": "application/json"},
    }).then((response) => {
    if (response) {
        return response
    }
    else{
        console.log("deleting project failed for project id: "+project_id);
        return [];
    }

    }).catch(() => {
    console.log("deleting project failed for project id: "+project_id);
    return [];
    })
}