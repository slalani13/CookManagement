import { credentialsData } from "./credentialsData";
import { User } from "./user.model";

export interface teamRequestData{
    name:string,
    description:string,
    company:number,
    credentials:credentialsData,
}

export interface teamResponseData{
    id:number,
    name:string,
    description:string,
    users:User[],
}
