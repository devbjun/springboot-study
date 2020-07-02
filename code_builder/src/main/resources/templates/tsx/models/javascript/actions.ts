import { createAction } from 'typesafe-actions';

export const UPDATE_JAVASCRIPT_CODE = 'javascript/UPDATE_CODE';
export const UPDATE_JAVASCRIPT_RESULT = 'javascript/UPDATE_RESULT';

export const updateJSCode = createAction(UPDATE_JAVASCRIPT_CODE)<string>();
export const updateJSResult = createAction(UPDATE_JAVASCRIPT_RESULT)<{ state: string, message: string }>();
