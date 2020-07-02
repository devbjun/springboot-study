import { useDispatch } from 'react-redux';
import { useCallback } from 'react';
import { selectLanguage } from '../../models/language';

export const useSelectLanguage = () => {
  const dispatch = useDispatch();
  return useCallback((language) => dispatch(selectLanguage(language)), [dispatch]);
};
