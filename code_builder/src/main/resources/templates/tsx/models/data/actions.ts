import { createAction } from 'typesafe-actions';

export const UPDATE_CODE = 'data/UPDATE_CODE';
export const UPDATE_RESULT = 'data/UPDATE_RESULT';

export const updateCode = createAction(UPDATE_CODE)<string>();
export const updateResult = createAction(UPDATE_RESULT)<{ state: string, message: string }>();
