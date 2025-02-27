import { User } from "./user.model";

export interface Company {
    id: number;
    name: string;
    description: string;
    users: User[];
    teams: Object[];
}