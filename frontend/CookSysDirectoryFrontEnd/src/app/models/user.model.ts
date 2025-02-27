import { profileData } from "./profileData";
import { Company } from "./company.model";
import { teamResponseData } from "./teamData";

export interface User {
    id: number;
    username: string;
    profile: profileData;
    active: boolean;
    status: string;
    admin: boolean;
    companies?: Company[];
    teams?: teamResponseData[];
}