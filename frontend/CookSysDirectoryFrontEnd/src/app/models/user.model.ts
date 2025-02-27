export interface ProfileDto {
    firstName: string;
    lastName: string;
    email: string;
    phone: string;
}

export interface User {
    id: number;
    username: string;
    profile: ProfileDto;
    active: boolean;
    status: string;
    admin: boolean;
    companies?: Object[];
    teams?: Object[];
}