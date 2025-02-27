export interface Announcement {
    id: number;
    title: string;
    message: string;
    date: Date;
    author: {
      id: number;
      profile: {
        firstName: string;
        lastName: string;
        email: string;
        phone: string;
      };
    };
  }