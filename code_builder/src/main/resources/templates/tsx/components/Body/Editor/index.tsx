import React from 'react';

import { UnControlled as CodeMirror } from 'react-codemirror2';
import 'codemirror/mode/javascript/javascript';
import 'codemirror/mode/python/python';

import { Language } from '../../../models/language/types.ts';
import { useLanguage } from '../../../hooks/language/useLanguage';

import { useJS } from '../../../hooks/javascript/useJS';
import { useUpdateJSCode } from '../../../hooks/javascript/useUpdateJSCode';

import { usePython } from '../../../hooks/python/usePython';
import { useUpdatePyCode } from '../../../hooks/python/useUpdatePyCode';

export default () => {

  const lang = useLanguage();

  const js = useJS();
  const updateJSCode = useUpdateJSCode();

  const python = usePython();
  const updatePyCode = useUpdatePyCode();

  return (
    <div className="editor" style={{ position: 'relative', top: '50px', height: '50%' }}>
      <CodeMirror 
        value={(() => {
          switch (lang) {
            case Language.JAVASCRIPT:
              return js.code;
            case Language.PYTHON:
              return python.code;
            default:
              return js.code;
          };
        })()}
        onChange={(editor: any, metadata: any, code: any) => {
          switch (lang) {
            case Language.JAVASCRIPT:
              updateJSCode(code);
              break;
            case Language.PYTHON:
              updatePyCode(code);
              break;
            default:
              updateJSCode(code);
          };
        }}
        options={(() => {

          const data = {
            mode : '',
            theme: 'material',
            lineNumbers: true
          };

          switch (lang) {
            case Language.JAVASCRIPT:
              data.mode = 'javascript';
              break;
            case Language.PYTHON:
              data.mode = 'python';
              break;
            default:
              data.mode = 'javascript';
              break;
          };

          return data;
        })()} 
      />
    </div>
  );
};