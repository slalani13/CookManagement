import { credentialsData } from "./credentialsData";
import { profileData } from "./profileData";


export interface UserRequest {
  credentials: credentialsData;
  profile: profileData;
  isAdmin: boolean;
}