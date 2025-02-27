import { credentialsData } from "./credentialsData";

export interface projectRequestData{
    name:string,
    description:string,
    team:number,
    active:boolean,
    credentials:credentialsData,
}

export interface projectResponseData{
    id:number,
    name:string,
    description:string,
    team:number,
    active:boolean,
}

export interface projectContent{
    content:string
}