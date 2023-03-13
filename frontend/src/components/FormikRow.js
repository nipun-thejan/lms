const FormikRow = (
  { type,
    name,
    value, 
    onChange, 
    labelText, 
    onBlur ,
    touch,
    err
    
  }) => {
  return (
    <div className='form-row'>
      <label htmlFor={name} className='form-label'>
        {labelText || name}
      </label>
      <input
        type={type}
        id={name}
        name={name}
        value={value}
        onChange={onChange}
        onBlur={onBlur}
        className='form-input'
      />
      
      {touch && err ? (
          <div className='error'>{err}</div>
        ) : null}
        
    </div>
  )
}



export default FormikRow
