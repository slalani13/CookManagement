import { credentialsData } from "./credentialsData";

export interface projectData{
    name:string,
    description:string,
    team:number,
    active:boolean,
    credentials:credentialsData,
}

export interface projectContent{
    content:string
}