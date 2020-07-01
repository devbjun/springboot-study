import { useDispatch } from 'react-redux';
import { useCallback } from 'react';
import { updateCode } from '../../models/data';

export const useUpdateCode = () => {
  const dispatch = useDispatch();
  return useCallback((code) => dispatch(updateCode(code)), [dispatch]);
};
