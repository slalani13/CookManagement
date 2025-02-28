import { fetchData } from "./fetchService";
import { contentRequestData, projectRequestData } from "../models/projectData";
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

export async function getProject(project_id:number){
    return fetchData({
    endpoint: `projects/${project_id}`,
    }).then((response) => {
    if (response) {
        return response
    }
    else{
        console.log("getting project failed for project id: "+project_id);
        return [];
    }

    }).catch(() => {
    console.log("getting project failed for project id: "+project_id);
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


export async function createProject(team_id:number, projectRequest:projectRequestData){
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

export async function updateProject(project_id:number, projectRequest:projectRequestData){
    return fetchData({
    endpoint: `projects/${project_id}`,
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

export async function updateProjectContent(project_id:number, contentRequest:contentRequestData){
    return fetchData({
    endpoint: `projects/${project_id}/content`,
    method: "PATCH",
    body: JSON.stringify(contentRequest),
    headers: {"Content-Type": "application/json"},
    }).then((response) => {
    if (response) {
        return response
    }
    else{
        console.log("updating project content failed for project id: "+project_id);
        return [];
    }

    }).catch(() => {
    console.log("updating project content failed for project id: "+project_id);
    return [];
    })
}

export async function deleteProject(project_id:number){
    return fetchData({
    endpoint: `projects/${project_id}`,
    method: "DELETE",
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