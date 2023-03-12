const FormikRow = (
  { type,
    name,
    value, 
    onChange, 
    labelText, 
    onBlur 
  }) => {
  return (
    <div className='form-row'>
      <label htmlFor={name} className='form-label'>
        {labelText || name}
      </label>
      <input
        type={type}
        value={value}
        name={name}
        onChange={onChange}
        onBlur={onBlur}
        className='form-input'
      />
    </div>
  )
}

export default FormikRow
