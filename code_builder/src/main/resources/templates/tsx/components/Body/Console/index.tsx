import React, { useEffect } from 'react';

import { Language } from '../../../models/language/types.ts';
import { useLanguage } from '../../../hooks/language/useLanguage';

import { useJS } from '../../../hooks/javascript/useJS';
import { useUpdateJSResult } from '../../../hooks/javascript/useUpdateJSResult';

import { usePython } from '../../../hooks/python/usePython';
import { useUpdatePyResult } from '../../../hooks/python/useUpdatePyResult';

export default () => {

  const lang = useLanguage();

  const js = useJS();
  const updateJSResult = useUpdateJSResult();

  const python = usePython();
  const updatePyResult = useUpdatePyResult();

  useEffect(() => {
    const init = {
      state: 'info',
      message: '코드를 실행해주세요!'
    };

    updateJSResult(init);
    updatePyResult(init);
  }, []);

  return (
    <div className="console has-background-grey-darker" style={{ position: 'relative', top: '50px', height: 'calc(50% - 50px)' }}>
      <article className={ 'tile is-child notification is-' + (() => {
          switch (lang) {
            case Language.JAVASCRIPT:
              return js.result.state;
            case Language.PYTHON:
              return python.result.state;
            default:
              return js.result.state;
          };
        })()} style={{ top: '50%', left: '50%', width: 'calc(100% - 25px)', height: 'calc(100% - 25px)', transform: 'translate(-50%, -50%)' }}>
        <p className="title">{(() => {
          switch (lang) {
            case Language.JAVASCRIPT:
              return 'JavaScript';
            case Language.PYTHON:
              return 'Python';
            default:
              return 'JavaScript';
          };
        })()} 실행 결과</p>
        <p className="subtitle">&gt; {(() => {
          switch (lang) {
            case Language.JAVASCRIPT:
              return 'node index.js';
            case Language.PYTHON:
              return 'python main.py';
            default:
              return 'node index.js';
          };
        })()}</p>
        <div className="content">
        {(() => {
          switch (lang) {
            case Language.JAVASCRIPT:
              return js.result.message;
            case Language.PYTHON:
              return python.result.message;
            default:
              return js.result.message;
          };
        })()}
        </div>
      </article>
    </div>
  );
};