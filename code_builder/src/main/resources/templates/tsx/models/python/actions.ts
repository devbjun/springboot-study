import { createAction } from 'typesafe-actions';

export const UPDATE_PYTHON_CODE = 'python/UPDATE_CODE';
export const UPDATE_PYTHON_RESULT = 'python/UPDATE_RESULT';

export const updatePyCode = createAction(UPDATE_PYTHON_CODE)<string>();
export const updatePyResult = createAction(UPDATE_PYTHON_RESULT)<{ state: string, message: string }>();
