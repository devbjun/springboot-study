import React, { useEffect } from 'react';
import axios from 'axios';

import { Language } from '../../models/language/types.ts';
import { useLanguage } from '../../hooks/language/useLanguage';
import { useSelectLanguage } from '../../hooks/language/useSelectLanguage';

import { useJS } from '../../hooks/javascript/useJS';
import { useUpdateJSCode } from '../../hooks/javascript/useUpdateJSCode';
import { useUpdateJSResult } from '../../hooks/javascript/useUpdateJSResult';

import { usePython } from '../../hooks/python/usePython';
import { useUpdatePyCode } from '../../hooks/python/useUpdatePyCode';
import { useUpdatePyResult } from '../../hooks/python/useUpdatePyResult';


export default () => {

  const lang = useLanguage();
  const selectLang = useSelectLanguage();

  const js = useJS();
  const updateJSCode = useUpdateJSCode();
  const updateJSResult = useUpdateJSResult();

  const python = usePython();
  const updatePyCode = useUpdatePyCode();
  const updatePyResult = useUpdatePyResult();

  useEffect(() => {
    selectLang(Language.JAVASCRIPT);
    updateJSCode('// Code');
    updatePyCode('# Code');
  }, []);

  const onClickHandler = (e: any) => {

    const data = {
      mode: '',
      code: ''
    };

    switch (lang) {
      case Language.JAVASCRIPT:
        data.mode = 'js';
        data.code = js.code;
        break;
      case Language.PYTHON:
        data.mode = 'python';
        data.code = python.code;
        break;
      default:
        data.mode = 'js';
        data.code = js.code;
    };

    axios.post('http://localhost:8000/build', data)
    .then((res) => {
      switch (lang) {
        case Language.JAVASCRIPT:
          updateJSResult(res.data);
          break;
        case Language.PYTHON:
          updatePyResult(res.data);
          break;
        default:
          updateJSResult(res.data);
      };
    })
    .catch((err) => {
      const res = {
        state: 'error',
        message: err
      };

      switch (lang) {
        case Language.JAVASCRIPT:
          updateJSResult(res);
          break;
        case Language.PYTHON:
          updatePyResult(res);
          break;
        default:
          updateJSResult(res);
      };
    });
  }

  const onClickHandlerDropDown = (e: any) => {
    switch (e.target.innerText) {
      case 'JavaScript':
        selectLang(Language.JAVASCRIPT);
        break;
      case 'Python':
        selectLang(Language.PYTHON);
        break;
      default:
        selectLang(Language.JAVASCRIPT);
    }
  }

  return (
    <div className="header">
      <nav className="navbar is-dark" role="navigation" aria-label="main navigation">
        <div className="navbar-brand">
          <a className="navbar-item" href="/">
            <strong style={{ fontSize: '24px' }}>Code Builder</strong>
          </a>

          <div className="navbar-item has-dropdown is-hoverable has-background-dark">
            <div className="navbar-link">
              {(() => {
                  switch (lang) {
                    case Language.JAVASCRIPT:
                      return 'JavaScript';
                    case Language.PYTHON:
                      return 'Python';
                    default:
                      return 'JavaScript';
                  };
                })()
              }
            </div>

            <div className="navbar-dropdown has-background-dark">
              <div className="navbar-item has-text-white" onClick={ onClickHandlerDropDown } style={{ cursor: 'pointer' }}>
                JavaScript
              </div>
              <div className="navbar-item has-text-white" onClick={ onClickHandlerDropDown } style={{ cursor: 'pointer' }}>
                Python
              </div>
            </div>
          </div>
          
          <div className="navbar-item" style={{ position: 'absolute', top: -2.5, right: 0 }}>
            <div className="button is-primary" onClick={ onClickHandler } style={{ width: '75px' }}>
              <strong>실행</strong>
            </div>
          </div>
        </div>
      </nav>
    </div>
  );  
};