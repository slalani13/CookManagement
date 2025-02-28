import { credentialsData } from "./credentialsData";

export interface projectRequestData{
    name:string,
    description:string,
    team:number,
    active:boolean,
}

export interface projectResponseData{
    id:number,
    name:string,
    description:string,
    team:number,
    active:boolean,
    content:string
}

export interface contentRequestData{
    content:string
}