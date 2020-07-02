import { useDispatch } from 'react-redux';
import { useCallback } from 'react';
import { updatePyCode } from '../../models/python';

export const useUpdatePyCode = () => {
  const dispatch = useDispatch();
  return useCallback((code) => dispatch(updatePyCode(code)), [dispatch]);
};
