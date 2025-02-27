import { profileData } from "./profileData";

export interface User {
    id: number;
    username: string;
    profile: profileData;
    active: boolean;
    status: string;
    admin: boolean;
    companies?: Object[];
    teams?: Object[];
}