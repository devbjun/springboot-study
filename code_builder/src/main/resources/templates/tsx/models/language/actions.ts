import { createAction } from 'typesafe-actions';
import { Language } from './types';

export const SELECT_LANGUAGE = 'language/SELECT_LANGUAGE';

export const selectLanguage = createAction(SELECT_LANGUAGE)<Language>();