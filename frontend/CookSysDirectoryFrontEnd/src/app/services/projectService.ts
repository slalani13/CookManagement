import { List, toPairs } from "lodash";
import { projectData } from "../models/projectData";
import "whatwg-fetch";
import { credentialsData } from "../models/credentialsData";

const BASE_URL = "http://localhost:8080";

/**
 * Parses the JSON returned by a network request
 *
 * @param  {object} response A response from a network request
 *
 * @return {object} The parsed JSON from the request
 */
const parseJSON = (response: any) => {
  if (response.status === 204 || response.status === 205) {
    return null;
  }
  return response.json();
};

/**
 * Requests a URL, returning a promise
 *
 * @param  {string} url       The URL we want to request
 * @param  {object} [options] The options we want to pass to "fetch"
 *
 * @return {object}           The response data
 */
export const request = (url: any, options?: any) => {
    return fetch(url, options).then(parseJSON);
};

const fetchData = ({ endpoint, method="GET", body, headers }: any) => {
    let url = [BASE_URL, endpoint].join("/");
    console.log("project url: "+url);
    if (headers) {
        const paramString = toPairs(headers)
        .map((param: any) => param.join("="))
        .join("&");
        url += `?${paramString}`;
    }
    const options: RequestInit = {
        method,
        headers,
        body
    };
    return request(url, options);
};


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


export async function createProject(team_id:number, projectRequest:projectData, credentialsRequest: credentialsData){
    return fetchData({
    endpoint: `projects/teams/${team_id}`,
    method: "POST",
    body: JSON.stringify({ projectRequest, credentialsRequest }),
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