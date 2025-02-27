import { toPairs } from "lodash";
import "whatwg-fetch";

const BASE_URL = "http://localhost:8080";

/**
 * Parses the JSON returned by a network request
 *
 * @param  {object} response A response from a network request
 *
 * @return {object} The parsed JSON from the request
 */
const parseJSON = (response: any) => {
  if (response.status === 204 || response.status === 205) {
    return null;
  }
  return response.json();
};

/**
 * Requests a URL, returning a promise
 *
 * @param  {string} url       The URL we want to request
 * @param  {object} [options] The options we want to pass to "fetch"
 *
 * @return {object}           The response data
 */
export const request = (url: any, options?: any) => {
    return fetch(url, options).then(parseJSON);
};

export const fetchData = ({ endpoint, method="GET", body, headers, params}: any) => {
    let url = [BASE_URL, endpoint].join("/");
    console.log("project url: "+url);
    if (params) {
        const paramString = toPairs(params)
        .map((param: any) => param.join("="))
        .join("&");
        url += `?${paramString}`;
    }
    const options: RequestInit = {
        method,
        headers,
        body
    };
    return request(url, options);
};
